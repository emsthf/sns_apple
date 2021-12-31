import React from "react";
import GridD from "../layout/GridD";
import AuthorBox from "../ui/author/AuthorBox";
import NextPage from "../ui/gridfull/NextPage";
import PostList from "../ui/gridfull/PostList";
import StickyBar from "../ui/gridfull/StickyBar";
import { Link } from "react-router-dom";

function Author() {
  return (
    <div className="site-content module-author">
      <div className="atbs-block atbs-block--fullwidth">
        <div className="container">
          <div className="row">
            <div className="atbs-main-col">
              <div className="author-box">
                <div className="author-box__image">
                  <div className="author-avatar">
                    <img
                      alt="Ryan Reynold"
                      src="http://via.placeholder.com/180x180"
                      className="avatar photo"
                    />
                  </div>
                </div>
                <div className="author-box__text">
                  <div className="author-name meta-font">
                    <Link to="" title="Posts by Ryan Reynold" rel="author">
                      Ryan Reynold
                    </Link>
                  </div>
                  <div className="author-bio">
                    A 26-year-old health centre receptionist who enjoys going to
                    the movies, photography and social media.
                  </div>
                  <div className="author-info">
                    <div className="row--flex row--vertical-center grid-gutter-20">
                      <ul className="list-unstyled list-horizontal list-space-sm">
                        <li>
                          <Link to="">
                            <i className="mdicon mdicon-mail_outline"></i>
                            <span className="sr-only">e-mail</span>
                          </Link>
                        </li>
                        <li>
                          <Link to="">
                            <i className="mdicon mdicon-twitter"></i>
                            <span className="sr-only">Twitter</span>
                          </Link>
                        </li>
                        <li>
                          <Link to="">
                            <i className="mdicon mdicon-facebook"></i>
                            <span className="sr-only">Facebook</span>
                          </Link>
                        </li>
                        <li>
                          <Link to="">
                            <i className="mdicon mdicon-google-plus"></i>
                            <span className="sr-only">Google+</span>
                          </Link>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
              <div className="atbs-block atbs-posts-lists">
                <div className="posts-lists__inner">
                  <div className="posts-lists__wrap">
                    <div className="post-vertical-lists-a">
                      <PostList />
                    </div>
                  </div>
                  <nav className="atbs-pagination ">
                    <h4 className="atbs-pagination__title sr-only">
                      Posts navigation
                    </h4>
                    <div className="atbs-pagination__links ">
                      <Link
                        className="atbs-pagination__item atbs-pagination-active__item "
                        to="#"
                      >
                        1
                      </Link>
                      <Link className="atbs-pagination__item" to="#">
                        2
                      </Link>
                      <Link className="atbs-pagination__item" to="#">
                        3
                      </Link>
                      <span className="atbs-pagination__item atbs-pagination__dots">
                        …
                      </span>
                      <Link className="atbs-pagination__item" to="#">
                        Next
                      </Link>
                      <Link
                        className="atbs-pagination__item atbs-pagination__item-next"
                        to="#"
                      >
                        <i className="mdicon mdicon-arrow_forward"></i>
                      </Link>
                    </div>
                  </nav>
                </div>
              </div>
            </div>
            <StickyBar />
          </div>
        </div>
      </div>
      <GridD />
    </div>
  );
}

export default Author;
