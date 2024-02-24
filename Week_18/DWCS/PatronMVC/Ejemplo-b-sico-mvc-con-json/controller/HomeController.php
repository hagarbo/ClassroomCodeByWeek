<?php

class HomeController
{

    public string $page_title;
    public string $view;

    public function __construct()
    {
        $this->view = 'index';
        $this->page_title = '';
    }

    public function list()
    {
        $this->page_title = "Home Page";
    }
}
