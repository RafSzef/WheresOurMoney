import * as React from 'react';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import {Link} from "react-router-dom";

export default function NavButtons({params}) {
    return (
        <Stack direction="row" spacing={1}>
            {params.map((elem) => {
                return <><Link to={elem.link}>
                    <Button>{elem.name}</Button>
                </Link>
                </>
            })}


            {/*<Button disabled>Disabled</Button>*/}
            {/*<Button href="#text-buttons">Link</Button>*/}
        </Stack>
    );
}