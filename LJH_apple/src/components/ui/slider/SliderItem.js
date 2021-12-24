import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

function SliderItem({postId}) {

    const [postItem, setPost] = useState({})
    const [cateName, setCateName] = useState("")

    const getCateName = (id) => {
        fetch(`http://localhost:3006/categories/${id}`)
        .then (res=>{
            return res.json()
         })
         .then(data=>{
            setCateName(data.name)
             
         })
    }

    useEffect(()=>{
        fetch(`http://localhost:3005/post/${postId}`)
        .then (res=>{
           return res.json()
        })
        .then(data=>{
            setPost(data)
            getCateName(data.categoryId)
            
        })
     },[postId])



    return (
        <div className="slider__item">
            <article className="post post--horizontal post--horizontal-reverse takei-slide-featured">
                <div className="post__thumb">
                    <div className="background-img" style={{background : `url('${postItem.titleImage}')`}}></div>
                    <Link to={`/single/${postId}`} className="link-overlay"></Link>
                </div>
                <div className=" post-text__wrap">
                    <div className="post__text">
                        <a href="category-1.html" className="post__cat takei-cat">{cateName}</a>
                        <h3 className="post__title takei-title typescale-5"> <Link to={`/single/${postId}`}>{postItem.postTitle}</Link></h3>
                    </div>
                </div>
            </article>
        </div> 
        
    );
}

export default SliderItem;