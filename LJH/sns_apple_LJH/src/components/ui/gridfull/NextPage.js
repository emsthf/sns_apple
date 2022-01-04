import React from "react";
import { Link } from "react-router-dom";

function NextPage() {
  return (
    <nav className="atbs-pagination ">
      <h4 className="atbs-pagination__title sr-only">Posts navigation</h4>
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
        <span className="atbs-pagination__item atbs-pagination__dots">…</span>
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
  );
}

export default NextPage;
