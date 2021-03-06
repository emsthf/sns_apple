import React, { useState, useEffect } from "react";
import axios from "axios";

import StickyAboutMe from "../stickybar/StickyAboutMe";
import StickyMiddlePost from "../stickybar/StickyMiddlePost";

function StickyBar({ userId }) {
  const [postDatas, setPostDatas] = useState([]); // 호출된 데이터가 담길 포스트 글 리스트

  useEffect(() => {
    const userUrl = `http://localhost:3005/post?userId=${userId}`; // 해당하는 유저의 글만 뽑아오기 위한 api 링크 주소
    // 해당유저의 글만 호출하기
    axios.get(userUrl).then((Response) => {
      console.log(Response);
      setPostDatas(Response.data);
    });
  }, [userId]);

  return (
    <div className="atbs-sub-col js-sticky-sidebar">
      <div className="atbs-widget widget atbs-widget-posts-list ">
        <div className="widget__title  ">
          <h4 className="widget__title-text">the latest news</h4>
        </div>
        <div className="widget-posts-list__inner  ">
          <StickyAboutMe />
          <div className="widget-post-horizontal-list clearfix">
            <ul className="posts-list list-unstyled widget-list-posts-horizontal">
              {postDatas
                .map((post) => <StickyMiddlePost key={post.id} post={post} />)
                .slice(1, 6)}
            </ul>
          </div>
        </div>
      </div>
      <div className="atbs-widget widget  atbs-subscribe">
        <div className="subscribe__inner ">
          <div className="subscriber-tile">
            <h3>subscriber</h3>
          </div>
          <div className="subscriber-excerpt">
            className aptent taciti sociosqud lito. Subscribe and join our club.
          </div>
          <div className="subscriber-form subscribe-form--horizontal max-width-sm">
            <input
              type="email"
              name="EMAIL"
              className="btn"
              placeholder="Enter your email"
              required=""
            />
            <input type="submit" value=">" className="btn" />
          </div>
        </div>
      </div>
    </div>
  );
}
export default StickyBar;
