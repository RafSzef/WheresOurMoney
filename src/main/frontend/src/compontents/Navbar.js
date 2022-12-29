import React from "react";
import logo from "../logo.svg";
import {Link} from "react-router-dom";


export default function Navbar() {
    return (<>
            <nav>
                <img src={logo} className="App-logo" alt="logo"/>
                <h3 className="nav--logo_text">WheresOurMoney</h3>
                <ul className="nav--list">
                    <li className="nav--list_item">
                        <Link className="nav--list_item_link"
                              to="/entries">Accounts</Link>
                    </li>
                    <li className="nav--list_item">
                        <Link className="nav--list_item_link"
                              to="/categories">Categories</Link>
                    </li>
                    <li className="nav--list_item">
                        <Link className="nav--list_item_link"
                              to="/users">Users</Link>
                    </li>
                </ul>
                <button className="nav--login_button">Login</button>
            </nav>
        </>
    )
}