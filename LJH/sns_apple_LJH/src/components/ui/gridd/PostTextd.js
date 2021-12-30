import React from "react";

function PostTextd() {
  return (
    <div className="post__text">
      <div className="post-meta-top">
        <div className="author">
          <Link to="author.html" className="author__avatar">
            <img src="http://via.placeholder.com/40x40" alt="file not found" />
          </Link>
          <div className="author__text ">
            <Link className="author__name" to="author.html">
              Adeline Eirene
            </Link>
            <p className="">London</p>
          </div>
        </div>
      </div>
      <h3 className="post__title typescale-4 takei-title">
        <Link to="single-1.html">
          The Only Thing You Can Get in a Hurry Is Trouble
        </Link>
      </h3>
    </div>
  );
}

export default PostTextd;
