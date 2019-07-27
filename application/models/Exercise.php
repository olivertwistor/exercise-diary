<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * This is a representation of an exercise instance. It maps to the
 * corresponding database table.
 *
 * @author Johan Nilsson
 * @since 0.1.0
 */
class Exercise extends MY_Model
{
    /**
     * Timestamp for this exercise instance, in the form of a MySQL timestamp
     * string.
     *
     * @var string
     *
     * @since 0.1.0
     */
    private $exercise_timestamp;

    /**
     * Type of exercise. An integer that maps to the row ID of the Exercise_type
     * class.
     *
     * @var int
     *
     * @since 0.1.0
     */
    private $exercise_type;

    /**
     * Number of repetitions, minutes or whichever unit is appropriate for the
     * exercise type.
     *
     * @var int
     *
     * @since 0.1.0
     */
    private $repetitions;
}
