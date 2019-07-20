<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Extends the CI_Controller with more functionality. All other controllers
 * should inherit from this one rather than from CI_Controller.
 *
 * @author Johan Nilsson
 * @since 0.1.0
 */
class MY_Controller extends CI_Controller
{
    /**
     * Loads three views: a header, a main section and a footer. An optional
     * array with data for these views can be supplied.
     *
     * This is a convenience method to use instead of calling
     * `$this->load->view()` three times, when you want to load a full page
     * with header, footer and something between. Often, you have the same
     * header and footer throughout the application. This method lets you just
     * specify the main section.
     *
     * @param string $main the main section view file without the extension
     * @param mixed $data optional data to send to all three view files
     * @param string $header the header view file without the extension;
     *               defaults to "header"
     * @param string $footer the footer view file without the extension;
     *               defaults to "footer"
     *
     * @since 0.1.0
     */
    protected function render_view(string $main, $data = [],
                                   string $header = 'header',
                                   string $footer = 'footer')
    {
        $this->load->view($header, $data);
        $this->load->view($main, $data);
        $this->load->view($footer, $data);
    }
}
