import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom'



function SinglePostSmall({id}) {


    const [nexData, setNextData] = useState({})
    const [prevData, setPrevData] = useState({})

    const prevUrl = `http://localhost:3005/post?id_lte=${id-1}`
    const nextUrl = `http://localhost:3005/post?id_gte=${parseInt(id) + 1}`

    useEffect(()=>{
        axios.get(prevUrl)
        .then(Response=>{
            // console.log(Response.data)
            setPrevData(Response.data[Response.data.length-1])

        })
        axios.get(nextUrl)
        .then(Response=>{
            // console.log(Response.data[0])
            // console.log(Response)
            setNextData(Response.data[0])
        })
    },[prevUrl, nextUrl])



    return ( 

        <div className="posts-navigation single-entry-section everly-single-entry clearfix">
            {
                prevData ?

                <div className="posts-navigation__prev">
                    <article className="post post--vertical ">
                        <div className="post__thumb">
                            <a className="navigation-button" href="single-1.html">
                                <div className="background-img" style={{ background: `url('../.${prevData.titleImage}')`}}></div>
                            </a>
                            <div className="post__meta ">
                                <Link to={`/single/${id-1}`}>
                                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="10" fill="var(--color-white)" viewBox="0 0 32 17">
                                    <path id="slider-prev" data-name="Slider Prev" className="slider_arrow_path" d="M8.158,0.007L8.835,0.685,1.5,8.019H32V8.979H1.5l7.338,7.334-0.677.679L0,8.839V8.16Z"></path>
                                </svg>
                                Prev
                                </Link>
                            </div>
                        </div>
                        <div className="post__text inverse-text">
                            <div className="post__text-wrap">
                                <div className="post__text-inner">
                                <h3 className="post__title"><a href="single-1.html">{prevData.postTitle}</a></h3>
                                </div>
                            </div>
                        </div>
                    </article>
                </div>

                :
                    
                ""
            }

            {
                nexData ? 
                <div className="posts-navigation__next">
                <article className="post post--vertical ">
                    <div className="post__thumb">
                        <a className="navigation-button" href="single-1.html">
                            <div className="background-img" style={{ background: `url('../.${nexData.titleImage}')`}}></div>
                        </a>
                        <div className="post__meta ">
                        <Link to={`/single/${parseInt(id) + 1}`}>
                            Next
                            <svg xmlns="http://www.w3.org/2000/svg" width="14" height="10" fill="var(--color-white)" viewBox="0 0 32 17">
                                <path id="slider-next" data-name="Slider Next" className="slider_arrow_path" d="M23.842,0.007l-0.677.678L30.5,8.019H0V8.979H30.5l-7.338,7.334,0.677,0.679L32,8.839V8.16Z"></path>
                            </svg>
                            
                            </Link>
                        </div>
                    </div>
                    <div className="post__text inverse-text">
                        <div className="post__text-wrap">
                            <div className="post__text-inner">
                            <h3 className="post__title"><a href="single-1.html">{nexData.postTitle}</a></h3>
                            </div>
                        </div>
                    </div>
                </article>
            </div>
            :
            ""
            }
            
        </div>
     );
}

export default SinglePostSmall;