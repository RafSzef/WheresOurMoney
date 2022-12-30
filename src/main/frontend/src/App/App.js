import './App.css';
import Navbar from "../compontents/Navbar";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import {ThemeProvider, createTheme} from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import EntryTable from "../compontents/EntryTable";
import UsersTable from "../compontents/UsersTable";
import CategoryTable from "../compontents/CategoryTable";
import Footer from "../compontents/Footer";

function App() {

    const darkTheme = createTheme({
        palette: {
            mode: 'dark',
        },
    });

    return (
        <ThemeProvider theme={darkTheme}>
            <CssBaseline/>
            <Router>
                <div className="App">
                    <Navbar/>
                    <Switch>
                        <Route path="/users">
                            <UsersTable/>
                        </Route>
                        <Route path="/categories">
                            <CategoryTable/>
                        </Route>
                        <Route path="/entries">
                            <EntryTable/>
                        </Route>
                    </Switch>
                    <Footer/>
                </div>
            </Router>
        </ThemeProvider>
    );
}

export default App;
