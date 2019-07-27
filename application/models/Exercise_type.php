<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Exercise_type extends CI_Model
{
    public function __construct()
    {
        parent::__construct();

        $this->load->database();
    }

    public function read_all() : array
    {
        // Mockup!
        $exercise_types = [
            '1' => 'Weight lifting',
            '2' => 'Gymnastics',
            '3' => 'Swimming'
        ];
        asort($exercise_types);

        return $exercise_types;
    }
}
