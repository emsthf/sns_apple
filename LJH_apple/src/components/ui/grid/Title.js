import React, { useEffect, useState } from 'react';


function Title({title, evenNumber}) {

    return ( 
        <div className={ evenNumber ? "block-heading block-takei-heading boxRight" : "block-heading block-takei-heading"}>
            <h4 className="heading__title milan-heading">
                {title}
            </h4>
            <span>{title}</span>
        </div>
     );
}

export default Title;