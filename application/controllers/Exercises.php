<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * This class controls the CRUD operations of exercises as well as serves
 * different views.
 *
 * @author Johan Nilsson
 * @since 0.1.0
 */
class Exercises extends MY_Controller
{
    public function __construct()
    {
        parent::__construct();

        $this->load->helper('form');
        $this->load->model('exercise');
        $this->load->model('exercise_type');
    }

    public function add() : void
    {
        $this->render_view('exercises/add_new', [
                'exercise_types' => $this->exercise_type->read_all()
            ]
        );
    }

    public function db_insert() : void
    {
        $success = $this->exercise->insert(
            $this->input->post('exercise-date'),
            $this->input->post('exercise-time'),
            $this->input->post('exercise-type'),
            $this->input->post('repetitions')
        );

        $insert_result = [];
        if ($success)
        {
            $insert_result['class'] = 'success';
            $insert_result['text'] = 'Exercise added to the database.';
        }
        else
        {
            $insert_result['class'] = 'failure';
            $insert_result['text'] = 'Failed to add exercise to the database.';
        }

        $this->render_view('exercises/add_new', [
            'exercise_types' => $this->exercise_type->read_all(),
            'insert_result' => $insert_result]
        );
    }
}
