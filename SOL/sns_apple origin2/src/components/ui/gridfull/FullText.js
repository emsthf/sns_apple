import React from 'react';
import { Link } from 'react-router-dom';


function FullText () {
    return ( 
        <div className="post__text">
            <div className="post-meta">
                <div className="post-date">
                <time className="time published" title="August 20, 2016 at 08:53 am">
                    <span className="post-day">18</span>
                    <span className="post-th-year">May 2019</span>
                </time>
                </div>
            </div>
            <h3 className="post__title takei-title typescale-3">
                <Link to="single-1.html">Difficult Roads Often Lead To Beautiful Destinations</Link>
            </h3>
            <div className="post__readmore clearfix">
                <Link to="single-1.html" className="button__readmore"><i className="mdicon mdicon-arrow_forward"></i></Link>
            </div>
        </div>
    );
}

export default  FullText ;