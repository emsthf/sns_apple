import React from "react";
import { Link } from "react-router-dom";

function Tags() {
  return (
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
  );
}

export default Tags;
