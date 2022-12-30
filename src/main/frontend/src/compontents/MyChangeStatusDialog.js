import React, { useState } from 'react';
import Dialog from '@material-ui/core/Dialog';
import Button from '@material-ui/core/Button';
import axios from 'axios';

function MyChangeStatusDialog({ params}) {
    console.log(params.row.id)
    const [open, setOpen] = useState(false);
    const handleOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleSubmit = () => {
        axios.put(`http://localhost:8080/category/changeActive/${params.row.id}`)
            .then((response) => {
                // handle success
                console.log(response)
            })
            .catch((error) => {
                console.log(error)
                // handle error
            });

        setOpen(false);
    };

    return (
        <>
            <Button onClick={handleOpen}>Change status</Button>
            <Dialog open={open} onClose={handleClose}>
                <form onSubmit={handleSubmit}>
                    <p>Are you sure you want to change the status of this category?</p>
                    <Button type="submit">Confirm</Button>
                    <Button onClick={handleClose}>Cancel</Button>
                </form>
            </Dialog>
        </>
    );
}

export default MyChangeStatusDialog;
