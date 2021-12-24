import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {Link, useLocation} from 'react-router-dom';
function AuthorDetail({userId, id}) {

    const dir = useLocation()

    const [user, setUser] = useState({})
    const [changeDir, setChangeDir] = useState("")

    useEffect(()=>{
        // console.log(dir)
        if(dir) setChangeDir("../.")
        const url = `http://localhost:3006/user/${userId}`
        axios.get(url)
        .then(Response=>{
            setUser(Response.data)
            
        })
     
    },[userId])

    return (      
        <div className="post-meta-top">
            <div className="author">
                <Link to="" className="author__avatar">
                    <img src={`${changeDir}./img/${user.profilePicture}`} alt={user.username}/>
                </Link>
                <div className="author__text">
                  <Link to={`/single/${userId}`} className="author__name">{user.username}</Link>
                    <p className="">{user.location}</p>
                </div>
            </div>
        </div>
     );
}

export default  AuthorDetail ;