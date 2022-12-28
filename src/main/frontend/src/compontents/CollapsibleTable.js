import * as React from 'react';
import {useEffect} from 'react';
import PropTypes from 'prop-types';
import Box from '@mui/material/Box';
import Collapse from '@mui/material/Collapse';
import IconButton from '@mui/material/IconButton';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Typography from '@mui/material/Typography';
import Paper from '@mui/material/Paper';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
import Toolbar from "@mui/material/Toolbar";
import {Grid, TextField} from "@mui/material";
import SearchIcon from '@mui/icons-material/Search';
import ComboBox from "./ComboBox";
import InputAdornment from "@mui/material/InputAdornment";
import InputWithIcon from "./InputWithIcon";
import Button from "@mui/material/Button";
import axios from "axios";

function Row(props) {
    const {row} = props;
    const [open, setOpen] = React.useState(false);

    return (
        <React.Fragment>
            <TableRow sx={{'& > *': {borderBottom: 'unset'}}}>
                <TableCell>
                    <IconButton
                        aria-label="expand row"
                        size="small"
                        onClick={() => setOpen(!open)}
                    >
                        {open ? <KeyboardArrowUpIcon/> : <KeyboardArrowDownIcon/>}
                    </IconButton>
                </TableCell>
                <TableCell component="th" scope="row">
                    {row.name}
                </TableCell>
                <TableCell align="right">{row.amount}</TableCell>
                <TableCell align="right">{row.timestamp}</TableCell>
                <TableCell align="right">{row.description}</TableCell>
                <TableCell align="right">{row.user.username}</TableCell>
                <TableCell align="right">{row.category.categoryTitle}</TableCell>
            </TableRow>
            {/*<TableRow>*/}
            {/*    <TableCell style={{paddingBottom: 0, paddingTop: 0}} colSpan={6}>*/}
            {/*        /!*<Collapse in={open} timeout="auto" unmountOnExit>*!/*/}
            {/*        /!*    <Box sx={{margin: 1}}>*!/*/}
            {/*        /!*        <Typography variant="h8" gutterBottom component="div">*!/*/}
            {/*        /!*            Szczegóły ogłoszenia*!/*/}
            {/*        /!*        </Typography>*!/*/}
            {/*        /!*        <Table size="small" aria-label="purchases">*!/*/}
            {/*        /!*            <TableHead>*!/*/}
            {/*        /!*                <TableRow>*!/*/}
            {/*        /!*                    <TableCell>column 1</TableCell>*!/*/}
            {/*        /!*                    <TableCell>column 2</TableCell>*!/*/}
            {/*        /!*                    <TableCell align="right">column 3</TableCell>*!/*/}
            {/*        /!*                    <TableCell align="right">column 4</TableCell>*!/*/}
            {/*        /!*                </TableRow>*!/*/}
            {/*        /!*            </TableHead>*!/*/}
            {/*        /!*            <TableBody>*!/*/}

            {/*        /!*                <TableRow>*!/*/}
            {/*        /!*                    <TableCell component="th" scope="row">*!/*/}
            {/*        /!*                        {row.publishDate}*!/*/}
            {/*        /!*                    </TableCell>*!/*/}
            {/*        /!*                    <TableCell>{row.expireDate}</TableCell>*!/*/}
            {/*        /!*                    <TableCell align="right">{row.user.username} {row.category.categoryTitle}</TableCell>*!/*/}
            {/*        /!*                    <TableCell align="right">*!/*/}
            {/*        /!*                        {row.description}*!/*/}
            {/*        /!*                    </TableCell>*!/*/}
            {/*        /!*                </TableRow>*!/*/}
            {/*        */}
            {/*        /!*            </TableBody>*!/*/}
            {/*        /!*        </Table>*!/*/}
            {/*        /!*    </Box>*!/*/}
            {/*        /!*</Collapse>*!/*/}
            {/*    </TableCell>*/}
            {/*</TableRow>*/}
        </React.Fragment>
    );
}

function User(props)
{
    const {user} = props;
    const [open, setOpen] = React.useState(false);
}

function Category(props)
{
    const {category} = props;
    const [open, setOpen] = React.useState(false);
}

Row.propTypes = {
    row: PropTypes.shape({
        timestamp: PropTypes.number,
        // id: PropTypes.number.isRequired,
        description: PropTypes.string.isRequired,
        amount: PropTypes.number,
        user: PropTypes.objectOf({User}).isRequired,
        category: PropTypes.objectOf({Category}).isRequired,
    }).isRequired,
};

User.propTypes = {
    user: PropTypes.shape({
        id: PropTypes.number.isRequired,
        firstName: PropTypes.string,
        lastName: PropTypes.string,
        usernameName: PropTypes.string.isRequired,
        password: PropTypes.string.isRequired,
        email: PropTypes.string,

    })
};

Category.propTypes = {
    category: PropTypes.shape( {
        id: PropTypes.number.isRequired,
        categoryTitle: PropTypes.string.isRequired,
    })
}

// const rows = [
//     createData('Frozen yoghurt', 159, 6.0, 24, 4.0, 3.99),
//     createData('Ice cream sandwich', 237, 9.0, 37, 4.3, 4.99),
//     createData('Eclair', 262, 16.0, 24, 6.0, 3.79),
//     createData('Cupcake', 305, 3.7, 67, 4.3, 2.5),
//     createData('Gingerbread', 356, 16.0, 49, 3.9, 1.5),
// ];

export default function CollapsibleTable() {
    const [filterOpen, setFilterOpen] = React.useState(false);
    const [data, setData] = React.useState([]);
    const [postData, setPostData] = React.useState([]);
    const url = 'http://localhost:8080/entry/all';

    // const getDataPost = async () => {
    //     await axios.post('http://localhost:8080/entry/all',
    //         createData("TestPost", 2000, 1))
    //         .then((response) => {
    //             const json = response.data;
    //             console.log(json);
    //             setPostData(json);
    //         })
    // }

    function createData(description, amount, user) {
        return {
            description,
            amount,
            user,
        }
    }


    const getData = async () => {
        await axios.get(url).then((response) => {
            const json = response.data;
            console.log(json);
            setData(json);
        })
    }

    useEffect(() => {
        getData();
    }, [])

    useEffect(() => {
        getDataPost();
    }, [])

    return (
        <>
            {/*<Box>*/}
            {/*    <Toolbar>*/}
            {/*        /!*<Grid container spacing={2}>*!/*/}
            {/*        /!*    /!*<Grid item sm={1}>*!/*!/*/}
            {/*        /!*    /!*    <TextField id="outlined-basic"*!/*!/*/}
            {/*        /!*    /!*               label="Search advertisement"*!/*!/*/}
            {/*        /!*    /!*               InputProps={{*!/*!/*/}
            {/*        /!*    /!*                   startAdornment: (*!/*!/*/}
            {/*        /!*    /!*                       <InputAdornment position="start">*!/*!/*/}
            {/*        /!*    /!*                           <SearchIcon/>*!/*!/*/}
            {/*        /!*    /!*                       </InputAdornment>*!/*!/*/}
            {/*        /!*    /!*                   ),*!/*!/*/}
            {/*        /!*    /!*               }}*!/*!/*/}
            {/*        /!*    /!*               variant="outlined"/>*!/*!/*/}
            {/*        /!*    /!*</Grid>*!/*!/*/}
            {/*        /!*    <Grid item sm={4}>*!/*/}
            {/*        /!*        /!*<ComboBox></ComboBox>*!/*!/*/}
            {/*        /!*    </Grid>*!/*/}
            {/*        /!*    /!*<Grid item sm={3}>*!/*!/*/}
            {/*        /!*    /!*    <Button color="inherit" variant="outlined" onClick={() => setFilterOpen(!filterOpen)}>*!/*!/*/}
            {/*        /!*    /!*        Filtruj*!/*!/*/}
            {/*        /!*    /!*    </Button>*!/*!/*/}
            {/*        /!*    /!*    <Collapse in={filterOpen} timeout="auto" unmountOnExit>*!/*!/*/}
            {/*        /!*    /!*        <InputWithIcon></InputWithIcon>*!/*!/*/}
            {/*        /!*    /!*    </Collapse>*!/*!/*/}
            {/*        /!*    /!*</Grid>*!/*!/*/}
            {/*        /!*</Grid>*!/*/}
            {/*    </Toolbar>*/}

            {/*</Box>*/}

            <TableContainer component={Paper}>
                <Table aria-label="collapsible table">
                    <TableHead>
                        <TableRow>
                            <TableCell/>
                            <TableCell align="right">Date</TableCell>
                            <TableCell align="right">Description</TableCell>
                            <TableCell align="right">Amount</TableCell>
                            <TableCell align="right">User</TableCell>
                            <TableCell align="right">Category</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {data.map((row) => (
                            <Row key={row.name} row={row}/>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </>
    );
}
