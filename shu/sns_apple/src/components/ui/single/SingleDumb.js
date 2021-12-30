import React from 'react';

function SingleDumb({titleImg}) {
    return ( 

        <div className="single__thumb">
            {titleImg}
        <div className="background-img" style={{ background: `url('../.${titleImg}')`}}></div>
     </div>


     );
}

export default SingleDumb;