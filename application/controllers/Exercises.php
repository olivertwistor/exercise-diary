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
        $insert_status = [];

        if (!is_null($this->input->post('save')))
        {
            $success = $this->db_insert();
            if ($success)
            {
                $insert_status['css_class'] = 'success';
                $insert_status['text'] = 'Successfully added the exercise.';
            }
            else
            {
                $insert_status = [
                    'css_class' => 'failure',
                    'text' => 'Failed to add the exercise.'
                ];
            }

        }

        $this->render_view('exercises/add_new', [
                'exercise_types' => $this->exercise_type->read_all(),
                'insert_status' => $insert_status
            ]
        );
    }

    private function db_insert() : bool
    {
        $success = $this->exercise->insert(
            $this->input->post('exercise-date'),
            $this->input->post('exercise-time'),
            $this->input->post('exercise-type'),
            $this->input->post('repetitions')
        );

        return $success;
    }
}
