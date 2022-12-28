import React from "react";
class DisplayTable extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            list: []
        }
        // this.callAPI().bind(this);
        this.callAPI();
    }

    callAPI() {
        fetch("http://localhost:8080/entry/all").then(
            response => response.json()
        ).then((data) => {
            console.log(data)
            this.setState({
                list: data.data
            })
        })
    }

    render() {
        let tb_data = this.state.list.map((item) => {
            return (
                <tr key={item.id}>
                    <td>{item.id}</td>
                    <td>{item.timestamp}</td>
                    <td>{item.description}</td>
                    <td>{item.user.username}</td>
                    <td>{item.category.categoryTitle}</td>
                </tr>
            )
        })

        return (
            <div className="container">
                <table>
                    <thread>
                        <tr>
                            <th>ID</th>
                            <th>Modified</th>
                            <th>Description</th>
                            <th>Username</th>
                            <th>Category</th>
                        </tr>
                    </thread>
                    <tbody>
                    {tb_data}
                    </tbody>

                </table>

            </div>
        )
    }
}

export default DisplayTable;