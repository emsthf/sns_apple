import React from 'react';

function NextPage() {
    return ( 

    <nav className="atbs-pagination ">
        <h4 className="atbs-pagination__title sr-only">Posts navigation</h4>
        <div className="atbs-pagination__links ">
            <a className="atbs-pagination__item atbs-pagination-active__item " href="#">1</a>
            <a className="atbs-pagination__item" href="#">2</a>
            <a className="atbs-pagination__item" href="#">3</a>
            <span className="atbs-pagination__item atbs-pagination__dots">…</span>
            <a className="atbs-pagination__item" href="#">Next</a>
            <a className="atbs-pagination__item atbs-pagination__item-next" href="#"><i className="mdicon mdicon-arrow_forward"></i></a>
        </div>
    </nav>



     );
}

export default NextPage;