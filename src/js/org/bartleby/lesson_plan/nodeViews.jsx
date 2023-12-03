import React from "react";

function Paragraph({ children }) {
  return <p>{children}</p>;
}

function List({ children }) {
  return <ul>{children}</ul>;
}

function ListItem({ children }) {
  return <li>{children}</li>;
}

export const reactNodeViews = {
    paragraph: () => ({
      component: Paragraph,
      dom: document.createElement("div"),
      contentDOM: document.createElement("span"),
    }),
    list: () => ({
      component: List,
      dom: document.createElement("div"),
      contentDOM: document.createElement("div"),
    }),
    list_item: () => ({
      component: ListItem,
      dom: document.createElement("div"),
      contentDOM: document.createElement("div"),
    }),
  };
  