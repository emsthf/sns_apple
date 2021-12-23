import React, { useEffect, useState } from 'react';
import SliderItem from '../ui/slider/SliderItem';
import SmallSliderItem from '../ui/slider/SmallSliderItem';

import OwlCarousel from 'react-owl-carousel';
import 'owl.carousel/dist/assets/owl.carousel.css';
import 'owl.carousel/dist/assets/owl.theme.default.css';

function Slider () {

   const [sliderList,setSliderList]=useState([])
   const [author,setAuthor]=useState([])
      useEffect(()=>{
         fetch("http://localhost:3006/slide")
         .then (res=>{
            return res.json()
         })
         .then(data=>{
            setSliderList(data)
            // console.log(data)
         })

         fetch("http://localhost:3006/userlist")
         .then (res=>{
            return res.json()
         })
         .then(data=>{
            setAuthor(data)
            // console.log(data)
         })
      },[])

    return(
      <div className="atbs-block atbs-block--fullwidth atbs-featured-slider">
         <div className="container">
            <div className="featured-slider__inner atbs-carousel">
               <div className="big-slider">
               <OwlCarousel className="owl-theme" items={1} loop autoplay> 
                  {
                     sliderList.map(item=>(<SliderItem key={item.id} postId={item.postId}/>))
                  }
               </OwlCarousel>
               </div>
               <div className="small-slider js-carousel-1i30m owl-carousel">
                  <div className="small-slider__item">
                     <ul className="post-slider clearfix">
                     <OwlCarousel className="owl-theme" items={1} loop autoplay>
                        {
                           author.map(item=>(
                              <SmallSliderItem 
                                 key={item.id}
                                 userId={item.userId}
                              />
                           )).slice(0,8)
                        }
                        
                     </OwlCarousel>
                     </ul>
                  </div>
               </div>
            </div>
         </div>
      </div>
    );
}

export default Slider;