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
        $this->load->helper('url');

        $this->load->model('exercise');
        $this->load->model('exercise_type');
    }

    public function index() : void
    {
        $this->list();
    }

    public function list() : void
    {
        $exercises = $this->exercise->read_all('exercise');

        if (empty($exercises))
        {
            $this->render_view('exercises/empty_list');
        }
        else
        {
            $this->render_view('exercises/list', [
                'exercises' => $exercises
            ]);
        }
    }

    public function add() : void
    {
        $insert_status = [];

        if (!is_null($this->input->post('save')))
        {
            // Store the POST data in an exercise object. The date and the
            // time must be concatenated into a timestamp first, though.
            $exercise_data = $this->input->post();
            $exercise_data['timestamp'] = $exercise_data['exercise_date'] .
                ' ' . $exercise_data['exercise_time'];
            $this->exercise->fill($exercise_data);

            $success = $this->exercise->create('exercise');
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

        $exercise_types = $this->exercise_type->read_all();

        $this->render_view('exercises/add_new', [
            'exercise_types' => $exercise_types,
            'insert_status' => $insert_status
        ]);
    }
}
