import React from "react";
import Title from "../ui/grid/Title";
import PostDumb from "../ui/gridd/PostDumb";
import PostMeta from "../ui/gridd/PostMeta";
import PostSmalld from "../ui/gridd/PostSmalld";
import PostTextd from "../ui/gridd/PostTextd";
import { Link } from "react-router-dom";

function GridD() {
  return (
    <>
      <div className="atbs-block atbs-block--fullwidth atbs-post-grid-d">
        <div className="container">
          <div className="post-grid-d__inner">
            <Title />
            <div className="post-grid-d__wrap">
              <div className="big-post-grid-d">
                <article className="post post--horizontal post--horizontal-sm">
                  <div className="post-meta">
                    <div className="meta__item">
                      <p className="title">Date</p>
                      <time
                        className="time published"
                        title="August 20, 2016 at 08:53 am"
                      >
                        jun 26, 2018
                      </time>
                    </div>
                    <div className="meta__item entry-tags ">
                      <p className="title">Tags</p>
                      <ul className="social-list social-list--md list-horizontal">
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
                    </div>
                  </div>
                  <div className="post__thumb">
                    <div className="background-img"></div>
                    <Link className="link-overlay" to="single-1.html"></Link>
                  </div>
                  <div className="post__text">
                    <div className="post-meta-top">
                      <div className="author">
                        <Link to="author.html" className="author__avatar">
                          <img
                            src="http://via.placeholder.com/40x40"
                            alt="file not found"
                          />
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
                </article>
              </div>
              <div className="small-post-grid-d">
                <article className="post post--horizontal flexbox flexbox--middle">
                  <div className="post__thumb">
                    <div className="background-img"></div>
                    <Link className="link-overlay" to="single-1.html"></Link>
                  </div>
                  <div className="post__text flexbox__item">
                    <h3 className="post__title takei-title typescale-2">
                      <Link to="single-1.html">
                        A Harmful Truth is Better Than a Useful Lie
                      </Link>
                    </h3>
                    <div className="post__excerpt">
                      Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                      sed do eiumod tempor incididunt ut labore.
                    </div>
                  </div>
                </article>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default GridD;
