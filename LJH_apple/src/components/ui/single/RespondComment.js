import React from 'react';


function RespondCommnet() {
    return ( 

    <div id="respond" className="comment-respond">
        <h3 id="reply-title" className="comment-reply-title">Leave a Reply <small><a rel="nofollow" id="cancel-comment-reply-link" href="index.thml" style={{display: "none"}}>Cancel reply</a></small></h3>
        <form action="#" method="post" id="commentform" className="comment-form" novalidate="">
            <p className="comment-notes"><span id="email-notes">Your email address will not be published.</span> Required fields are marked <span className="required">*</span></p>
                <p className="comment-form-comment">
                    <label for="comment">Comment</label>
                    <textarea id="comment" name="comment" cols="45" rows="8" maxlength="65525" required="required"></textarea>
                </p>
            <p className="comment-form-author">
                    <label for="author">Name <span className="required">*</span></label>
                    <input id="author" name="author" type="text" value="" size="30" maxlength="245" required="required"/>
            </p>
            <p className="comment-form-email">
                <label for="email">Email <span className="required">*</span></label>
                <input id="email" name="email" type="email" value="" size="30" maxlength="100" aria-describedby="email-notes" required="required"/>
            </p>
            <p className="comment-form-url">
                <label for="url">Website</label>
                <input id="url" name="url" type="url" value="" size="30" maxlength="200"/>
            </p>
            <p className="form-submit">
                <input name="submit" type="submit" id="submit" className="submit" value="Post Comment"/>
                <input type="hidden" name="comment_post_ID" value="44" id="comment_post_ID"/>
                <input type="hidden" name="comment_parent" id="comment_parent" value="0"/>
            </p>
        </form>
    </div>




     );
}

export default RespondCommnet;

        



