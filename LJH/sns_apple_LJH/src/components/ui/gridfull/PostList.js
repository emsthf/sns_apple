import React from "react";
import AuthorDetail from "../grid/AuthorDetail";
import FullDumb from "./FullDumb";
import FullText from "./FullText";
import Tags from "./Tags";
import { Link } from "react-router-dom";

function PostList() {
  return (
    <div className="post-vertical-style-a post-list-takei">
      <article className="post post--vertical">
        <div className="post-top clearfix flexbox flexbox--middle">
          <AuthorDetail />
          <div className="comment-views-tags top-right flexbox__item">
            <ul className="list-horizontal-top clearfix">
              <li>
                <i className="mdicon mdicon-visibility"></i>70 Views
              </li>
              <li>
                <i className="mdicon mdicon-comments-o"></i>20 Comment
              </li>
              <li className="entry-tags">
                <ul className="social-list social-list--md list-horizontal">
                  <li>
                    <i className="mdicon mdicon-local_offer"></i>
                  </li>
                  <li>
                    <Link to="tags.html">video</Link>
                  </li>
                  <li>
                    <Link to="tags.html">travel</Link>
                  </li>
                  <li>
                    <Link to="tags.html">fashion</Link>
                  </li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
        <div className="post__thumb">
          <div className="background-img"></div>
          <Link className="link-overlay" to="single-1.html"></Link>
        </div>
        <div className="post__text">
          <div className="post-meta">
            <div className="post-date">
              <time
                className="time published"
                title="August 20, 2016 at 08:53 am"
              >
                <span className="post-day">18</span>
                <span className="post-th-year">May 2019</span>
              </time>
            </div>
          </div>
          <h3 className="post__title takei-title typescale-3">
            <Link to="single-1.html">
              Difficult Roads Often Lead To Beautiful Destinations
            </Link>
          </h3>
          <div className="post__readmore clearfix">
            <Link to="single-1.html" className="button__readmore">
              <i className="mdicon mdicon-arrow_forward"></i>
            </Link>
          </div>
        </div>
      </article>
    </div>
  );
}

export default PostList;
