import React from "react";
import Title from "../ui/grid/Title";
import PostText from "../ui/grid/PostText";
import { Link } from "react-router-dom";

function GridA() {
  return (
    <div className="atbs-block atbs-block--fullwidth atbs-post-grid-a">
      <div className="container">
        <div className="post-grid-a__inner">
          <Title />
          <div className="post-grid-a__wrap">
            <div className="post-horizontal-grid-a">
              <article className="post post--horizontal">
                <PostText />
              </article>
            </div>
            <div className="post-overlay-grid-a">
              <article className="post post--overlay">
                <div className="post__thumb">
                  <div className="background-img"></div>
                  <Link className="link-overlay" to="single-1.html"></Link>
                </div>
                <div className="post__text">
                  <h3 className="post__title typescale-1">
                    <Link to="single-1.html">
                      A Loving Heart is The Truest Wisdom
                    </Link>
                  </h3>
                </div>
              </article>
            </div>
            <div className="post-vertical-grid-a">
              <article className="post post--vertical">
                <div className="post-vertical-top">
                  <div className="post__thumb">
                    "<div className="background-img"></div>
                    <Link className="link-overlay" to="single-1.html"></Link>
                  </div>
                  <div className="post__text">
                    <h3 className="post__title typescale-1">
                      <Link to="single-1.html">
                        The Wisest Men Follow Their Own Direction
                      </Link>
                    </h3>
                  </div>
                </div>
                <div className="post-meta">
                  <div className="author">
                    <Link to="author.html" className="author__avatar">
                      <img
                        src="http://via.placeholder.com/40x40"
                        alt="file not found"
                      />
                    </Link>
                    <div className="author__text">
                      <Link className="author__name" to="author.html">
                        Adeline Eirene
                      </Link>
                      <p className="">London</p>
                    </div>
                  </div>
                </div>
              </article>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default GridA;
