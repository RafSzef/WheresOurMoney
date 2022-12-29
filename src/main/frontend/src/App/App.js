import './App.css';
import Navbar from "../compontents/Navbar";

import EntryTable from "../compontents/EntryTable";
import UsersTable from "../compontents/UsersTable";
import CategoryTable from "../compontents/CategoryTable";

function App() {
    return (
        <div className="App">
            <Navbar></Navbar>
            {/*<EntryTable></EntryTable>*/}
            {/*<UsersTable></UsersTable>*/}
            <CategoryTable></CategoryTable>
            <header className="App-header">
            </header>
        </div>
    );
}

export default App;
