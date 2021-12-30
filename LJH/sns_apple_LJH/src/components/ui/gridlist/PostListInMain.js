import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function PostListInMain({ postData }) {
  const [post, setPost] = useState(postData);

  useEffect(() => {
    console.log(post);
  });

  return (
    <div className="post__thumb">
      <div className="background-img" style={{}}></div>
      <Link className="link-overlay" to="single-1.html"></Link>
    </div>
  );
}

export default PostListInMain;
