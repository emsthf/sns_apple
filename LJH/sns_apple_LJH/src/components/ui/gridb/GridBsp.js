import React, { useEffect, useState } from "react";

function GridBsp(userId) {
  return (
    <li className="post-horizontal-list__item clearfix">
      <article className="post post--horizontal post--horizontal-middle post--horizontal-sm">
        <div className="post__thumb">
          <div
            className="background-img"
            style={{ background: `url('./img/01.jpg')` }}
          ></div>
          <Link className="link-overlay" to="single-1.html"></Link>
        </div>
        <div className="post__text">
          <div className="post-meta">
            <time
              className="time published"
              title="August 20, 2016 at 08:53 am"
            >
              {}
            </time>
          </div>
          <h3 className="post__title typescale-1">
            <Link to="single-1.html">
              The Wisest Men Follow Their Own Direction
            </Link>
          </h3>
          <div className="post-meta-top hidden-lg hidden-md">
            <div className="author">
              <Link to="single-1.html" className="author__avatar">
                <img
                  src="http://via.placeholder.com/40x40"
                  alt="file not found"
                />
              </Link>
              <div className="author__text ">
                <Link className="author__name" to="author.html">
                  {}
                </Link>
                <p className="">{}</p>
              </div>
            </div>
          </div>
        </div>
      </article>
    </li>
  );
}

export default GridBsp;
