import React from "react";
import Title from "../ui/grid/Title";
import NextPage from "../ui/gridfull/NextPage";
import PostList from "../ui/gridfull/PostList";
import StickyBar from "../ui/gridfull/StickyBar";

function GridFull() {
  return (
    <>
      <div className="atbs-block atbs-block--fullwidth">
        <div className="container">
          <div className="row">
            <div className="atbs-main-col">
              <div className="atbs-block atbs-posts-lists">
                <div className="posts-lists__inner">
                  <Title />
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
    </>
  );
}

export default GridFull;
