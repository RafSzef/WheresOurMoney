import * as React from 'react';
import {DataGrid} from '@mui/x-data-grid';
import {useEffect, useState} from "react";
import axios from "axios";

function CategoryTable({params}) {
    const [tableData, setTableData] = useState([])
    const [loadingData, setLoadingData] = React.useState(false)

    useEffect(() => {
        async function getData() {
            axios.get("http://localhost:8080/category/all/")
                .then((response) => {
                    console.log(response.data);
                    setTableData(response.data);
                    setLoadingData(true);
                })
        }
        if (!loadingData) {
            getData();
        }
    }, [])

    const columns = [
        {field: 'id', headerName: 'ID'},
        {field: 'categoryTitle', headerName: 'Category Name'},
    ];


    return (
        <div style={{height: 400, width: '100%'}}>
            <DataGrid
                rows={tableData}
                columns={columns}
                pageSize={5}
                rowsPerPageOptions={[5]}
                checkboxSelection
            />
        </div>
    );
}

export default CategoryTable