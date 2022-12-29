import * as React from 'react';
import {DataGrid} from '@mui/x-data-grid';
import {useEffect, useState} from "react";
import axios from "axios";

function EntryTable({params}) {
    const [tableData, setTableData] = useState([])
    const [loadingData, setLoadingData] = React.useState(false)

    useEffect(() => {
        async function getData() {
            axios.get("http://localhost:8080/entry/all/")
                .then((response) => {
                    setTableData(response.data);
                    setLoadingData(true);
                })
        }
        if (!loadingData) {
            getData();
        }
    }, [])

    const detailsRows = tableData.map((row) => {
        return {
            id: row.id,
            timestamp: row.timestamp,
            amount: row.amount,
            user: row.user.username,
            category: row.category.categoryTitle,
            description: row.description,
        };
    })

    const columns = [
        {field: 'id', headerName: 'ID'},
        {field: 'timestamp', headerName: 'Date'},
        {field: 'amount', headerName: 'Amount'},
        {field: 'user', headerName: 'Username'},
        {field: 'category', headerName: 'Category'},
        {field: 'description', headerName: 'Description'},
    ];


    return (
        <div style={{height: 400, width: '100%'}}>
            <DataGrid
                rows={detailsRows}
                columns={columns}
                pageSize={5}
                rowsPerPageOptions={[5]}
                checkboxSelection
            />
        </div>
    );
}

export default EntryTable