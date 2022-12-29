import React from "react";
import logo from "../logo.svg";
import {Link} from "react-router-dom";
import NavButtons from "./NavButtons";


export default function Navbar() {

    const buttons = [
        {id: 1, name: "Entries", link:"/entries" },
        {id: 2, name: "categories", link:"/categories" },
        {id: 3, name: "Users", link:"/users" },
        {id: 4, name: "Login", link:"/login" },
    ]

    return (<>
            <nav>
                <img src={logo} className="App-logo" alt="logo"/>
                <h3 className="nav--logo_text">WheresOurMoney</h3>
                <NavButtons params = {buttons}/>

                {/*<ul className="nav--list">*/}
                {/*    <li className="nav--list_item">*/}
                {/*        <Link className="nav--list_item_link"*/}
                {/*              to="/entries">Accounts</Link>*/}
                {/*    </li>*/}
                {/*    <li className="nav--list_item">*/}
                {/*        <Link className="nav--list_item_link"*/}
                {/*              to="/categories">Categories</Link>*/}
                {/*    </li>*/}
                {/*    <li className="nav--list_item">*/}
                {/*        <Link className="nav--list_item_link"*/}
                {/*              to="/users">Users</Link>*/}
                {/*    </li>*/}
                {/*</ul>*/}
                {/*<button className="nav--login_button">Login</button>*/}
            </nav>
        </>
    )
}