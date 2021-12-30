import React from "react";
import { Link } from "react-router-dom";

function GridADumb() {
  return (
    <div className="post__text">
      <div className="post__thumb">
        <div
          className="background-img"
          style={{ background: `url('http://via.placeholder.com/470X650')` }}
        ></div>
        <Link className="link-overlay" to="single-1.html"></Link>
      </div>
    </div>
  );
}

export default GridADumb;
