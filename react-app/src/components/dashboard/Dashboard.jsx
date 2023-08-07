import React, { useState, useEffect } from "react";
import { DataGrid } from '@mui/x-data-grid';
import { Button, Stack, Checkbox, Divider } from "@mui/material";
import { useLocation, useNavigate } from "react-router-dom";
import { getAllTrades, getUserTrades } from "../../services/DashboardService";

export const Dashboard = () => {
    const { state } = useLocation();
    const navigate = useNavigate();

    const [data, setData] = useState([]);

    const [myBondFilter, setMyBondFilter] = useState(false);
    const [myBondData, setMyBondData] = useState([]);
    const [bondData, setBondData] = useState([]);

    const cols = [
        {field: "id", headerName: "ID", width: 50},
        {field: "currency", headerName: "Currency", width: 100},
        {field: "quantity", headerName: "Quantity", width: 100},
        {field: "unit_price", headerName: "Unit Price", width: 100},
        {field: "buy_sell", headerName: "Buy / Sell", width: 100},
        {field: "book_name", headerName: "Trading Book", width: 100},
        {field: "counter_party_name", headerName: "Bond Holder", width: 100},
        {field: "isin", headerName: "ISIN", width: 100},
        {field: "cusip", headerName: "CUSIP", width: 100},
        {field: "issuer_name", headerName: "Bond Issuer", width: 100},
        {field: "maturity_date", headerName: "Maturity Date YYYY-MM-DD", width: 100},
        {field: "coupon", headerName: "Coupon%", width: 100},
        {field: "type", headerName: "Bond Type", width: 100},
        {field: "face_value", headerName: "Face Value", width: 100},
        {field: "security_currency", headerName: "Security Currency", width: 100},
        {field: "status", headerName: "Status", width: 100},
        {field: "trade_date", headerName: "Trade Date YYYY-MM-DD", width: 100},
        {field: "settlement_date", headerName: "Settlement Date YYYY-MM-DD", width: 100},
    ];

    const rows = [];

    const handleSubmit = (event) => {
        event.preventDefault();
        navigate('/', {state: {}});
    };

    const handleMyBondsFilterToggle = () => {
        setMyBondFilter(!myBondFilter)
        console.log(myBondFilter)
        return
    };

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
        if (myBondFilter) {
            setData(myBondData);
        } else {
            setData(bondData);
        }
    }, [myBondFilter]);

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
            </Stack>
        </div>
        <div>
            <DataGrid rows={rows} columns={cols} getRowId={(row) => row.id}
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