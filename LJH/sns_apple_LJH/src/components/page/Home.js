import React, { useEffect, useState } from "react";
import axios from "axios";
import GridList from "../layout/GridList.js";
import Slider from "../layout/Slider";
import { Link } from "react-router-dom";

function Home() {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    const url = "http://localhost:3006/categories/";
    axios.get(url).then((Response) => {
      // console.log(Response.data)
      setCategories(Response.data);
    });
  }, []);

  return (
    <div className="site-content">
      <Slider />
      {categories &&
        categories.map((category) => (
          <GridList
            key={category.id}
            id={category.id}
            categoryName={category.name}
          />
        ))}
    </div>
  );
}

export default Home;
