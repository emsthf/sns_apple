import React, { useEffect, useState } from 'react';


function SmallSliderItem({userId}) {


    const [slideProfile, setSlideProfile]=useState({})

    useEffect(()=>{
        fetch(`http://localhost:3006/user/${userId}`)
        .then (res=>{
            return res.json()
        })
        .then(data=>{
            // console.log(data)
            setSlideProfile(data)
        })
    },[])

    const imgUrl = {
        backgroundImage : `url('./img/${slideProfile.profilePicture}')`
    }

    return ( 
            <li className="slide-content clearfix">
                <article className="post post--horizontal post--horizontal-sm post--horizontal-middle">
                    <div className="post__thumb ">
                        <div className="background-img" style={imgUrl}></div>
                        <a className="link-overlay" href="single-1.html"></a>
                    </div>
                    <div className="post__text">
                        <h3 className="post__title typescale-1">{slideProfile.username}</h3>
                        <div className="post-meta">
                            <time className="time published"  title="August 20, 2016 at 08:53 am">{slideProfile.created}</time>
                        </div>
                    </div>
                </article>
            </li>
     );
}

export default SmallSliderItem;