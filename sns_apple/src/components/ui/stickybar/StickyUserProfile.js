import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

function StickyUserProfile({id}) {

    const [userData, setUserData] = useState({})

    useEffect(()=>{
        console.log(id)
        axios.get(`http://localhost:3006/user/${id}`)
        .then(Response=>{
            setUserData(Response.data)
            console.log(Response.data)
        })

    },[id])
    return ( 
        <div className="author__wrap clearfix">
                  <div className="author">
                     <Link to="" className="author__avatar">
                        <img src={`../../img/${userData.profilePicture}`} alt={userData.username}/>
                     </Link>
                     <div className="author__text">
                        <a className="author__name" href="author.html">{userData.username}</a>
                        <p className="">{userData.location}</p>
                     </div>
                  </div>
               </div>
     );
}

export default StickyUserProfile;