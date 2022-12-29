import './App.css';
import Navbar from "../compontents/Navbar";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";

import EntryTable from "../compontents/EntryTable";
import UsersTable from "../compontents/UsersTable";
import CategoryTable from "../compontents/CategoryTable";

function App() {
    return (
        <Router>
            <div className="App">
                <Navbar />
                <Switch>
                    <Route path="/users">
                        <UsersTable />
                    </Route>
                    <Route path="/categories">
                        <CategoryTable />
                    </Route>
                    <Route path="/entries">
                        <EntryTable/>
                    </Route>
                </Switch>
                {/*<EntryTable></EntryTable>*/}
                {/*<UsersTable></UsersTable>*/}
                {/*<CategoryTable></CategoryTable>*/}

            </div>
        </Router>
    );
}

export default App;
