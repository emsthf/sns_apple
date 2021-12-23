import { useEffect } from "react";
import { useLocation } from "react-router-dom";

export default function TopTo() {
  const { pathname } = useLocation();

  useEffect(() => {
    window.scrollTo(0, 0);
    // console.log(pathname)
  }, [pathname]);

  return null;
}
