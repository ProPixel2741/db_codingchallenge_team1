import React, { useState, useEffect } from "react";
import { DataGrid } from '@mui/x-data-grid';
import { Button } from "@mui/material";
import { useLocation } from "react-router-dom";
import { getAllTrades } from "../../services/DashboardService";

export const Dashboard = () => {
    const { state } = useLocation();
    const [data, setData] = useState([]);

    const handleSubmit = (event) => {
        event.preventDefault();
        window.location.href="http://localhost:3000/";
    }

    useEffect(() => {
        getAllTrades(state.token)
              .then(({data}) => {
              setData(data);
              });
    }, [state]);
    
    const rows = [];

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

    const cols = [
        {field: "id", headerName: "ID", width: 150},
        {field: "currency", headerName: "Currency", width: 150},
        {field: "quantity", headerName: "Quantity", width: 150},
        {field: "unit_price", headerName: "Unit Price", width: 150},
        {field: "buy_sell", headerName: "Buy / Sell", width: 150},
        {field: "book_name", headerName: "Trading Book", width: 150},
        {field: "counter_party_name", headerName: "Counter Party", width: 150},
        {field: "isin", headerName: "ISIN", width: 150},
        {field: "cusip", headerName: "CUSIP", width: 150},
        {field: "issuer_name", headerName: "Bond Issuer", width: 150},
        {field: "maturity_date", headerName: "Maturity Date YYYY-MM-DD", width: 150},
        {field: "coupon", headerName: "Coupon%", width: 150},
        {field: "type", headerName: "Bond Type", width: 150},
        {field: "face_value", headerName: "Face Value", width: 150},
        {field: "security_currency", headerName: "Security Currency", width: 150},
        {field: "status", headerName: "Status", width: 150},
        {field: "trade_date", headerName: "Trade Date YYYY-MM-DD", width: 150},
        {field: "settlement_date", headerName: "Settlement Date YYYY-MM-DD", width: 150},
    ];

    

    return (
        <>
        <h1>Bond Dashboard</h1>
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
        <div>
            {/* Display tradesData and booksData in your component */}
            <h2>Trades Data:</h2>
            <pre>{JSON.stringify(data, null, 2)}</pre>
        </div>
        </>
    )
}