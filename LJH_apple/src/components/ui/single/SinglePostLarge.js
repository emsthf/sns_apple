import React, { useEffect, useState } from 'react';
import { Link  } from 'react-router-dom';
import axios from 'axios';

import StickyUserProfile from '../stickybar/StickyUserProfile';

function SinglePostLarge() {

    const [postDatas, setPostDatas] = useState([])

    useEffect(() => {

        const url = `http://localhost:3005/post?_start=0&_end=4`

        axios.get(url)
            .then(Response => {
                console.log(Response)
                setPostDatas(Response.data)
            })
    }, [])

    return (

        <div className="atbs-block">
            <div className="single-block-heading widget__title  ">
                <h4 className="widget__title-text">the latest news</h4>
            </div>
            <div className="post-vertical-lists-b row ">
                {
                    postDatas.map(item => (
                        <LastNewsLargeBox
                            key={item.id}
                            postData={item}
                        />
                    ))
                }
            </div>
        </div>




    );
}


const LastNewsLargeBox = ({ postData }) => {

    return (
        <div className="col-sm-6 post-list-takei post-vertical-style-b">
            <article className="post post--vertical">
                <div className="post__thumb">
                    <div className="post__thumb-wrap">
                        <div className="background-img" style={{ background: `url('../.${postData.titleImage}')` }}></div>
                        <Link className="link-overlay" to={`/single/${postData.id}`}></Link>
                    </div>
                    <div className="post-meta">
                        <div className="post-date">
                            <time className="time published" title="August 20, 2016 at 08:53 am">
                                <span className="post-day">{postData.created}</span>
                            </time>
                        </div>
                    </div>
                </div>
                <div className="post__text">
                    <h3 className="post__title takei-title typescale-2">
                        <a href="single-1.html">{postData.postTitle}</a>
                    </h3>
                    <div className="post-top clearfix flexbox flexbox--middle">
                        <div className="post-meta-top top-left">
                            <div className="author">
                                <div className="author__text">
                                    <StickyUserProfile id={postData.userId} />

                                </div>
                            </div>
                        </div>
                        <div className="comment-views-tags top-right flexbox__item">
                            <ul className="list-horizontal-top">
                                <li><i className="mdicon mdicon-visibility"></i>70 Views</li>
                                <li><i className="mdicon mdicon-comments-o"></i>20 Comment</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </article>
        </div>
    );
}
export default SinglePostLarge;