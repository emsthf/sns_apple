import React from "react";
import { Link } from "react-router-dom";

function StickyBottonPost() {
  return (
    <div className="widget-vertical-list__item post-list-takei post-vertical-style-b">
      <article className="post post--vertical">
        <div className="post__thumb">
          <div className="post__thumb-wrap thumb-wrap-sm ">
            <div className="background-img"></div>
            <Link className="link-overlay" to="single-1.html"></Link>
          </div>
          <div className="post-meta">
            <div className="post-date">
              <time
                className="time published"
                title="August 20, 2016 at 08:53 am"
              >
                <span className="post-day">18</span>
                <span className="post-th-year">May</span>
              </time>
            </div>
          </div>
        </div>
        <div className="post__text">
          <h3 className="post__title typescale-1">
            <Link to="single-1.html">
              The Wisest Men Follow Their Own Direction
            </Link>
          </h3>
        </div>
      </article>
    </div>
  );
}

export default StickyBottonPost;
