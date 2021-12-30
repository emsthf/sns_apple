import React from 'react';

function NextPage() {
    return ( 

    <nav className="atbs-pagination ">
        <h4 className="atbs-pagination__title sr-only">Posts navigation</h4>
        <div className="atbs-pagination__links ">
            <Link className="atbs-pagination__item atbs-pagination-active__item " href="#">1</Link>
            <Link className="atbs-pagination__item" href="#">2</Link>
            <Link className="atbs-pagination__item" href="#">3</Link>
            <span className="atbs-pagination__item atbs-pagination__dots">…</span>
            <Link className="atbs-pagination__item" href="#">Next</Link>
            <Link className="atbs-pagination__item atbs-pagination__item-next" href="#"><i className="mdicon mdicon-arrow_forward"></i></Link>
        </div>
    </nav>



     );
}

export default NextPage;