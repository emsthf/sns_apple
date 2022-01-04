import React from "react";
import { Link } from "react-router-dom";
import AuthorDetail from "../grid/AuthorDetail";

function PostText() {
  return (
    <div className="post__text">
      <h3 className="post__title typescale-4 takei-title">
        <Link to="single-1.html">Fortune Sides With Him Who Dares.</Link>
      </h3>
      <div className="author"></div>
      <AuthorDetail />
    </div>
  );
}

export default PostText;
