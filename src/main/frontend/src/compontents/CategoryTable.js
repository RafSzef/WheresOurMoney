import * as React from 'react';
import {useEffect, useState} from 'react';
import axios from "axios";
import {Button, Grid, TextField} from "@material-ui/core";
import {DataGrid} from "@mui/x-data-grid";
import SendIcon from '@mui/icons-material/Send';

function CategoryTable({params}) {
    const [tableData, setTableData] = useState([])
    const [loadingData, setLoadingData] = React.useState(false)
    const [postData, setPostData] = React.useState('')
    let msg = '';

    let handleChange = (event) => {
        setPostData(event.target.value);
        console.log(postData)
    }

    const renderDeleteButton =  (params) => {
        return (
            <strong>
                <Button
                    variant="contained"
                    color="secondary"
                    size="small"
                    style={{ marginLeft: 16 }}
                onClick={() => {
                    alert(params.row.id)

                    }}
                >
                    Delete category
                </Button>
            </strong>
        )
    }


    async function removeData(categoryId) {
        axios
            .delete("http://localhost:8080/category/delete/", categoryId )
            .then((response) => {
                const json = response.data;
                console.log(json)
            })
            .catch(err => {
                console.log(err)
            })
    }
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

    function createData() {
        return {
            categoryTitle: postData
        }
    }

    async function setData() {
        axios
            .post("http://localhost:8080/category/add/", createData())
            .then((response) => {
                const json = response.data;
                msg = "Category added"
                console.log(json)
            })
            .catch(err => {
                console.log(err)
                msg = err
            })
    }

    const columns = [
        {field: 'id', headerName: 'ID'},
        {field: 'categoryTitle', headerName: 'Category Name', width: 200},
        {field: 'remove', headerName: 'Remove category', renderCell: renderDeleteButton, width: 200}
    ];


    //TODO clean up unused params; change navigation buttons color
    return (
        <div>
            {/*<div style={{backgroundColor: "dimgray", alignItems: "center", display: "table", position: "sticky", width: "100%"}}>*/}
            <Grid container style={{position: "sticky", width: "100%", backgroundColor: "#282c34"}}>
                <Grid item alignItems="stretch" style={{display: "flex", marginLeft: "20px"}}>
                    <TextField style={{backgroundColor: "#e0e0e0", color: "revert", margin: "15px 10px 15px 10px"}}
                               id="standard-basic-normal"
                               size="normal"
                               margin="normal"
                               label="Insert category name"
                        // value={buttonValue}
                               variant="filled"
                               onChange={handleChange}/>
                </Grid>
                <Grid item alignItems="stretch" style={{display: "flex", margin: "15px 10px 15px 10px"}}>
                    <Button
                        variant="contained"
                        size="large"
                        // color="secondary"
                        endIcon={<SendIcon/>}
                        onClick={() => {
                            setData();

                            function refreshPage() {
                                window.location.reload();
                            }

                            refreshPage()
                        }}>
                        Add category
                    </Button>
                </Grid>
            </Grid>
            <div style={{height: 400, width: '100%'}}>
                <DataGrid style={{color: "white", backgroundColor: "#282c34"}}
                          rows={tableData}
                          columns={columns}
                          pageSize={5}
                          rowsPerPageOptions={[5]}
                          checkboxSelection
                />
            </div>
        </div>
    );
}

export default CategoryTable