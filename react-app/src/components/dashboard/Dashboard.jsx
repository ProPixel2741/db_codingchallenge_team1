import React, { useState, useEffect } from "react";
import { DataGridPro } from '@mui/x-data-grid-pro';
import { Button, Stack, Checkbox, Divider } from "@mui/material";
import { DatePicker } from "@mui/x-date-pickers";
import { useLocation, useNavigate } from "react-router-dom";
import { getAllTrades, getUserTrades } from "../../services/DashboardService";

export const Dashboard = () => {
    const { state } = useLocation();
    const navigate = useNavigate();

    const [data, setData] = useState([]);
    const [myBondData, setMyBondData] = useState([]);
    const [bondData, setBondData] = useState([]);

    const [date,setDate] = useState("");

    const [myBondFilter, setMyBondFilter] = useState(false);
    const [myDateFilter,setMyDateFilter] = useState(false);

    


    let formattedDate = "";

    const formatDate = (date) => {
        if((parseInt(date['$M'],10)+1)<10){
            formattedDate = date['$y']+'-'+("0"+(parseInt(date['$M'],10)+1))+'-'+date['$D'];
        }else {
            formattedDate = date['$y']+'-'+(parseInt(date['$M'],10)+1)+'-'+date['$D'];
        }
        return formattedDate;
    } 


    const cols = [
        {field: "id", headerName: "ID", flex: 1, resizable: true},
        {field: "currency", headerName: "Currency", flex: 1, resizable: true},
        {field: "quantity", headerName: "Quantity", flex: 1, resizable: true},
        {field: "unit_price", headerName: "Unit Price", flex: 1, resizable: true},
        {field: "buy_sell", headerName: "Buy / Sell", flex: 1, resizable: true},
        {field: "book_name", headerName: "Trading Book", flex: 1, resizable: true},
        {field: "counter_party_name", headerName: "Bond Holder", flex: 1, resizable: true},
        {field: "isin", headerName: "ISIN", flex: 1, resizable: true},
        {field: "cusip", headerName: "CUSIP", flex: 1, resizable: true},
        {field: "issuer_name", headerName: "Bond Issuer", flex: 1, resizable: true},
        {field: "maturity_date", headerName: "Maturity Date YYYY-MM-DD", flex: 1, resizable: true},
        {field: "coupon", headerName: "Coupon%", flex: 1, resizable: true},
        {field: "type", headerName: "Bond Type", flex: 1, resizable: true},
        {field: "face_value", headerName: "Face Value", flex: 1, resizable: true},
        {field: "security_currency", headerName: "Security Currency", flex: 1, resizable: true},
        {field: "status", headerName: "Status", flex: 1, resizable: true},
        {field: "trade_date", headerName: "Trade Date YYYY-MM-DD", flex: 1, resizable: true},
        {field: "settlement_date", headerName: "Settlement Date YYYY-MM-DD", flex: 1, resizable: true},
    ];

    const rows = [];

    const getDatesAroundEnteredDate = (formattedDate) => {
        const dates = [];
        const currentDate = new Date(formattedDate);
    
        for(let i =- 5; i <= 5; i++){
            const newDate = new Date(currentDate);
            newDate.setDate(currentDate.getDate() + i);
            dates.push(newDate.toISOString().split('T')[0]);
        }
        return dates;
       }

    const handleSubmit = (event) => {
        event.preventDefault();
        navigate('/', {state: {}});
    };

    const handleMyBondsFilterToggle = () => {
        setMyBondFilter(!myBondFilter)
        console.log(myBondFilter)
        return
    };
    
    const handleMyDateFilterToggle = () => {
        setMyDateFilter(!myDateFilter);
    }


    useEffect(() => {
        getAllTrades(state.token)
            .then(({data}) => {
                setData(data);
                setBondData(data)
            });
        getUserTrades(state.token, state.username)
            .then(({data}) => {
                setMyBondData(data);
            });
    }, [state]);
    
    useEffect(() => {
        if (myBondFilter && !myDateFilter) {
            setData(myBondData);
        } else if(myBondFilter && myDateFilter){
            const dates = getDatesAroundEnteredDate(formatDate(date));
            const newData = [];
            for (var i = 0; i <myBondData.length; i++) {
                if (dates.indexOf(myBondData[i].security.maturity_date)>-1){
                    newData.push(myBondData[i]);
                }  
            }
            setData(newData);
        }else if(!myBondFilter && myDateFilter){
            const dates = getDatesAroundEnteredDate(formatDate(date));
            const newData = [];
            for (var i = 0; i < bondData.length; i++) {
                if (dates.indexOf(bondData[i].security.maturity_date)>-1){
                    newData.push(bondData[i]);
                }  
            }
            setData(newData);
        }else{
            setData(bondData);
        } 
    }, [myBondFilter, myDateFilter]);


    function jsonParseToRow(jsonObject, uniqueId) {
        return {
            id: uniqueId,
            currency: jsonObject.currency,
            quantity: jsonObject.quantity,
            unit_price: jsonObject.unit_price,
            buy_sell: jsonObject.buy_sell,
            book_name: jsonObject.book.name,
            counter_party_name: jsonObject.counterParty.name,
            isin: jsonObject.security.isin,
            cusip: jsonObject.security.cusip,
            issuer_name: jsonObject.security.issuer_name,
            maturity_date: jsonObject.security.maturity_date,
            coupon: jsonObject.security.coupon,
            type: jsonObject.security.type,
            face_value: jsonObject.security.face_value,
            security_currency: jsonObject.security.currency,
            status: jsonObject.security.status,
            trade_date: jsonObject.trade_date,
            settlement_date: jsonObject.settlement_date,
        }
    }

    for (var i = 0; i < data.length; i++) {
        rows.push(jsonParseToRow(data[i], i+1));
    }

    return (
        <>
        <h1>Bond Dashboard</h1>
        <div className={"filters"}>
            <Stack label="Filters" spacing={2} direction="row" divider={<Divider orientation="vertical" flexItem/>}>
                <div>
                    <label>Show my Bonds</label>
                    <Checkbox checked={myBondFilter} label="Show my Bonds" onChange={handleMyBondsFilterToggle}/>  
                </div>
                <div>
                    <DatePicker label="Select a date" onChange={(date) => setDate(date)} />
                    <Checkbox checked={myDateFilter} disabled={!date} label="Filter Date" onChange={handleMyDateFilterToggle}/> 
                </div>
            </Stack>
        </div>
        <div>
            <DataGridPro rows={rows} columns={cols} getRowId={(row) => row.id}
                sx={{
                    m:5,
                    boxShadow: 2,
                    border: 2,
                    borderColor: 'grey.500',
                    '& .MuiDataGrid-cell:hover': {
                    color: 'primary.main',
                    },
                }}
            />
            <Button variant="contained" onClick={handleSubmit}>Logout</Button>
        </div>
        </>
    )
}