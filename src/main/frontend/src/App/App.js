import './App.css';
import Navbar from "../compontents/Navbar";

import CollapsibleTable from "../compontents/CollapsibleTable";

function App() {
    return (
        <div className="App">
            <Navbar></Navbar>
            <header className="App-header">
                <CollapsibleTable></CollapsibleTable>
            </header>
        </div>
    );
}

export default App;
