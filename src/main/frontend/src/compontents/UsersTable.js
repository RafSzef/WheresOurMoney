import * as React from 'react';
import {DataGrid} from '@mui/x-data-grid';
import {useEffect, useState} from "react";
import axios from "axios";

function UsersTable({params}) {
    const [tableData, setTableData] = useState([])
    const [loadingData, setLoadingData] = React.useState(false)

    useEffect(() => {
        async function getData() {
            axios.get("http://localhost:8080/user/all/")
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

    const detailsRows = tableData.map((row) => {
        return {
            id: row.id,
            firstName: row.firstName,
            lastName: row.lastName,
            username: row.username,
            roles: row.roles.map((i) => i.name),
        };
    })

    const columns = [
        {field: 'id', headerName: 'ID'},
        {field: 'firstName', headerName: 'First Name'},
        {field: 'lastName', headerName: 'Last Name'},
        {field: 'username', headerName: 'Username'},
        {field: 'roles', headerName: 'Roles'},
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

export default UsersTable